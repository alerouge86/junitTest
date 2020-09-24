package com.alerouge.prova1.testing;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class RepoDummy {

	public List<String> getStuff() throws SQLException {
		return Arrays.asList("ale", "alberto", "vita", "cri");
	}
	
}
