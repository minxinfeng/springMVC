package com.bcps.service.impl;

import com.bcps.model.request.TestEntityRequest;
import com.bcps.model.response.TestEntityResponse;
import com.bcps.service.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public TestEntityResponse getTestEntity(TestEntityRequest testEntityRequest){
		TestEntityResponse testEntityResponse = new TestEntityResponse();
		testEntityResponse.setTestId("ID:" + testEntityRequest.getTestId());
		testEntityResponse.setTestName("NAME:" + testEntityRequest.getTestName());
		testEntityResponse.setTestDesc("DESC:" + testEntityRequest.getTestDesc());
		return testEntityResponse;
	}

}
