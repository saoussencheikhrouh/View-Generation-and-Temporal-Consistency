import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;


public class Abstraction extends AbstractHandler
{

@Override
public Object execute(ExecutionEvent event) throws ExecutionException {
	// TODO Auto-generated method stub
	 new GetInputAbs().run();
	return null;
}
 

}
