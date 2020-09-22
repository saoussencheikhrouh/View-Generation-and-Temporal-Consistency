import java.io.File;
import java.io.PrintStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class SelectPBP
  extends AbstractHandler
{
  public Object execute(ExecutionEvent event)
    throws ExecutionException
  {
    Shell shell = new Shell();
    FileDialog dialog = new FileDialog(shell, 4096);
    dialog.setFilterExtensions(new String[] { "*.bpmn" });
    dialog.setFilterPath("c:\\temp");
    String result = dialog.open();
    
   
    
    String nomFichier = result.substring(result.lastIndexOf("\\") + 1, result.length());
    
    Parseur1.setNomFichier(nomFichier);
    Parseur1.setNomFichierComplet(result);
    System.out.println(Parseur1.getNomFichierComplet());


    File fileToOpen = new File(Parseur1.getNomFichierComplet());
   // System.out.println(fileToOpen.exists());
   // System.out.println(fileToOpen.isFile());
    
  
   
    	
      IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
      IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      try
      {
        IDE.openInternalEditorOnFileStore(page, fileStore);
        
      }
      catch (PartInitException localPartInitException) {}
    
    return result;
  }
}
