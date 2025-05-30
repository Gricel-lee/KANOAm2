/**
 * generated by Xtext 2.30.0
 */
package org.xtext.example.mydsl.formatting2;

import com.google.inject.Inject;
import dsl.Capability;
import dsl.Mission;
import dsl.ProblemSpecification;
import dsl.Robot;
import dsl.TasksModel;
import dsl.WorldModel;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private MyDslGrammarAccess _myDslGrammarAccess;

  protected void _format(final ProblemSpecification problemSpecification, @Extension final IFormattableDocument document) {
    EList<WorldModel> _worldModel = problemSpecification.getWorldModel();
    for (final WorldModel worldModel : _worldModel) {
      document.<WorldModel>format(worldModel);
    }
    EList<TasksModel> _tasksModel = problemSpecification.getTasksModel();
    for (final TasksModel tasksModel : _tasksModel) {
      document.<TasksModel>format(tasksModel);
    }
    EList<Robot> _robotsModel = problemSpecification.getRobotsModel();
    for (final Robot robot : _robotsModel) {
      document.<Robot>format(robot);
    }
    EList<Mission> _mission = problemSpecification.getMission();
    for (final Mission mission : _mission) {
      document.<Mission>format(mission);
    }
  }

  protected void _format(final Robot robot, @Extension final IFormattableDocument document) {
    EList<Capability> _capabilities = robot.getCapabilities();
    for (final Capability capability : _capabilities) {
      document.<Capability>format(capability);
    }
  }

  public void format(final Object problemSpecification, final IFormattableDocument document) {
    if (problemSpecification instanceof XtextResource) {
      _format((XtextResource)problemSpecification, document);
      return;
    } else if (problemSpecification instanceof ProblemSpecification) {
      _format((ProblemSpecification)problemSpecification, document);
      return;
    } else if (problemSpecification instanceof Robot) {
      _format((Robot)problemSpecification, document);
      return;
    } else if (problemSpecification instanceof EObject) {
      _format((EObject)problemSpecification, document);
      return;
    } else if (problemSpecification == null) {
      _format((Void)null, document);
      return;
    } else if (problemSpecification != null) {
      _format(problemSpecification, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(problemSpecification, document).toString());
    }
  }
}
