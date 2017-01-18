package tools.vitruv.framework.vsum.ui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ProjectNamePage extends WizardPage implements KeyListener {

  private static final String PAGENAME = "Vitruvius Project";
  private static final String DESCRIPTION = "Create a new Vitruvius Project.";
  private static final String LABELTEXT = "Projektname: ";
  
  private Text text;
  private String enteredName;
  private Composite container;

  protected ProjectNamePage(NewVitruvWizard wizard) {
    super(PAGENAME);
    setTitle(PAGENAME);
    setDescription(DESCRIPTION);
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    layout.numColumns = 2;
    Label l1 = new Label(container, SWT.NONE);
    l1.setText(LABELTEXT);
    text = new Text(container, SWT.BORDER | SWT.SINGLE);
    text.setText("");
    text.addKeyListener(this);
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    text.setLayoutData(gd);

    setControl(container);
    setPageComplete(false);

  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if(!text.getText().isEmpty()){
      enteredName = text.getText();
      setPageComplete(true);
    } else {
      setPageComplete(false);
    }
  }
  
  /**
   * Returns the name which the user has entered.
   * @return String representation of the entered name
   */
  public String getEnteredName(){
    return enteredName;
  }

}