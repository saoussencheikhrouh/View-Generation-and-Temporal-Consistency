
import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

import plugin.Parseur;

public class DisplayView
  extends AbstractHandler
{
  private IWorkbenchWindow window;
  
  public Object execute(ExecutionEvent event)
    throws ExecutionException
  {
	  
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

    if (!Parseur1.getNomFichier().equals(""))
    {
   
    	String file = Parseur1.getNomFichierComplet();
    	
    	int pos = file.indexOf(".bpmn");
		String interm = file.substring(0, pos);
		String fileResult = interm+"_view"+".bpmn";
    	
      File fileToOpen = new File( fileResult);
      
      if ((fileToOpen.exists()) && (fileToOpen.isFile()))
      {
    	  
        IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try
        {
          IDE.openInternalEditorOnFileStore(page, fileStore);
        }
        catch (PartInitException localPartInitException) {}
        
       
      }
      else
      {
    	  MessageDialog.openInformation(
    		        window.getShell(), 
    		        "View Generation", 
    		        "Impossible To Generate View From Private Business Process In This Case.");
    	  
    	 
      }
    }
    else
    {
      MessageDialog.openInformation(
        window.getShell(), 
        "View Generation", 
        "Select First A Private Business Process");
    }
    return null;
  }
}
