package model;

/**
 * Saves all relevant data to the process.
 * 
 * @author Julius Langenberg, AH811
 *
 */
public class Data {
	// The host address
	private String host;
	// The port to communicate with
	private int port;

	/**
	 * Sets the host and port values
	 * 
	 * @param hostIn The host address that should be used
	 * @param portIn The port that should be used
	 */
	public Data(String hostIn, int portIn) {
		this.host = hostIn;
		this.port = portIn;
	}

	// Getters and Setters \\

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
