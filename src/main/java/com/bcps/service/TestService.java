package com.bcps.service;

import com.bcps.model.request.TestEntityRequest;
import com.bcps.model.response.TestEntityResponse;

public interface TestService {
	
	
	public TestEntityResponse getTestEntity(TestEntityRequest testEntityRequest);

}
