import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.jdom2.JDOMException;

import part1.abstraction.ElementOperation;

/**
 * This class demonstrates JFace's InputDialog class
 */
public class GetInputAbs extends ApplicationWindow {
	/**
	 * GetInput constructor
	 */
	public GetInputAbs() {
		super(null);
	}

	/**
	 * Runs the application
	 */
	public void run() {
		// Don't return from open() until window closes
		setBlockOnOpen(true);

		// Open the main window
		open();

		// close();

		// Dispose the display
		// Display.getCurrent().close();
	}

	/**
	 * Configures the shell
	 * 
	 * @param shell
	 *            the shell
	 */
	protected void configureShell(Shell shell) {
		super.configureShell(shell);

		// Set the title bar text
		shell.setText("Abstraction");
		shell.setSize(500, 500);

	}

	/**
	 * Creates the main window's contents
	 * 
	 * @param parent
	 *            the main window
	 * @return Control
	 */
	protected Control createContents( Composite parent) {
		 Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		// Create a label to display what the user typed in
		final Label label = new Label(composite, SWT.NONE);
		label.setText("Define Source and Destination to Generate a View from Private Process");

		// Create the button to launch the error dialog
		Button show = new Button(composite, SWT.PUSH);
		show.setText("Start");

		show.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				String src = "";
				String dst = "";

				boolean b = false;
				while (!b) {
					InputDialog dlg = new InputDialog(Display.getCurrent()
							.getActiveShell(), "Abstraction", "Source", label
							.getText(), null);
					if (dlg.open() == Window.OK) {
						// User clicked OK; update the label with the input
						// label.setText(dlg.getValue());

						src = dlg.getValue();
						try {
							b = AbstractionOperation.verif(
									Parseur1.getNomFichierComplet(), src);
							
							//System.out.println(b);
						} catch (JDOMException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (b)
							Parseur1.setSrc(src);
						else {
							
							 final JPanel panel = new JPanel();

							 JOptionPane.showMessageDialog(panel, "The Name of Source is incorrect",
									 "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
                
				boolean b1=false;
				while(!b1)
				{
				InputDialog dlg1 = new InputDialog(Display.getCurrent()
						.getActiveShell(), "Abstraction", "Destination", label
						.getText(), null);
				if (dlg1.open() == Window.OK) {
					// User clicked OK; update the label with the input
					// label.setText(dlg.getValue());

					dst = dlg1.getValue();
					
					try {
						b1=AbstractionOperation.verif(Parseur1.getNomFichierComplet(), dst);
					} catch (JDOMException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(b1)
					{
					Parseur1.setDst(dst);

					// System.out.println(Parseur1.getSrc());
					// System.out.println(Parseur1.getDst());

					try {
						AbstractionOperation.abstraction(
								Parseur1.getNomFichierComplet(),
								Parseur1.getSrc(), Parseur1.getDst());
					} catch (JDOMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					close();
					}
					
					else
					{
						 final JPanel panel = new JPanel();

						 JOptionPane.showMessageDialog(panel, "The Name of Destination is incorrect",
								 "Error", JOptionPane.ERROR_MESSAGE);
					}

				}
				}

			}

		});

		parent.pack();
		return composite;
	}

	/**
	 * The application entry point
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new GetInputAbs().run();
	}
}
