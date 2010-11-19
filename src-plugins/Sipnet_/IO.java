
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import java.util.Collection;
import java.util.HashSet;

import ij.IJ;

public class IO {

	public boolean exists(String filename) {

		return (new File(filename)).exists();
	}

	public boolean newer(String filename1, String filename2) {

		return ((new File(filename1)).lastModified() > (new File(filename2)).lastModified());
	}

	public void writeMsers(Collection<Candidate> topMsers, String filename) {

		File outfile = new File(filename);

		try {
			FileOutputStream out = new FileOutputStream(outfile);
	
			ObjectOutput oout = new ObjectOutputStream(out);
	
			oout.writeInt(topMsers.size());

			for (Candidate mser : topMsers)
				mser.writeExternal(oout);

			out.flush();

		} catch (FileNotFoundException e) {

			IJ.log("File " + filename + " could not be opened for writing.");
			e.printStackTrace();

		} catch (IOException e) {

			IJ.log("Something went wrong when trying to write to " + filename);
			e.printStackTrace();
		}
	}

	public HashSet<Candidate> readMsers(String filename) {

		HashSet<Candidate> regions = new HashSet<Candidate>();

		File infile = new File(filename);

		try {
			FileInputStream in = new FileInputStream(infile);
	
			ObjectInput oin = new ObjectInputStream(in);
	
			int numMsers = oin.readInt();
			IJ.log("Trying to read " + numMsers + " top msers");

			for (int i = 0; i < numMsers; i++) {
				Candidate region = new Candidate(0, 0, new double[0]);
				region.readExternal(oin);
				regions.add(region);
			}

		} catch (FileNotFoundException e) {

			IJ.log("File " + filename + " could not be opened for reading.");
			e.printStackTrace();

		} catch (IOException e) {

			IJ.log("Something went wrong when trying to read from " + filename);
			e.printStackTrace();
		}

		return regions;
	}
}
