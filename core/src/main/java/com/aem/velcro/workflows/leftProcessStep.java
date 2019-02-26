package com.aem.velcro.workflows;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.aem.velcro.core.OsgiServiceInterface;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
@Component
@Service
public class leftProcessStep implements WorkflowProcess{

	@Reference
	OsgiServiceInterface  obj;
	@Override
	public void execute(WorkItem wItm, WorkflowSession wSessn, MetaDataMap mDMap) throws WorkflowException {
		// TODO Auto-generated method stub
		WorkflowData data = wItm.getWorkflowData();
		String path = data.getPayload().toString();
	//	path=path+"/content/jcr:content";

		obj.addNodeFromService(path,"left");
		
	}

}
