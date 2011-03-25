package sipnet;

import java.util.List;
import java.util.Vector;

public class Sipnet {

	private SequenceSearch  sequenceSearch;

	public Sipnet(
			List<Vector<Candidate>> sliceCandidates,
			String                  parameterFilename,
			AssignmentModel         assignmentModel) {

		sequenceSearch =
				new SequenceSearch(
						sliceCandidates,
						parameterFilename,
						assignmentModel,
						false);
	}

	public Sequence bestSearch() {

		return sequenceSearch.getBestAssignmentSequence();
	}
}
