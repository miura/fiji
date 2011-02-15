package sipnet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@SuppressWarnings("serial")
public class Assignment extends LinkedList<SingleAssignment> {

	public Set<Candidate> getTargets() {

		Set<Candidate> targets = new HashSet<Candidate>();

		for (SingleAssignment singleAssignment : this)
			for (Candidate target : singleAssignment.getTargets())
				if (target != SequenceSearch.deathNode)
					targets.add(target);

		return targets;
	}

	public double getCosts() {

		double costs = 0.0;

		for (SingleAssignment singleAssignment : this)
			costs += singleAssignment.getCosts();

		return costs;
	}
}