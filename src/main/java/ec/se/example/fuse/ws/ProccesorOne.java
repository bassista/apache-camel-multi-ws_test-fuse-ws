package ec.se.example.fuse.ws;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

public class ProccesorOne implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
		MessageContentsList msgListIn = (MessageContentsList)inMessage.getBody();
		List<String> params = new ArrayList<String>();
		params.add(msgListIn.get(0).toString());
		inMessage.setBody(params,ArrayList.class);
		inMessage.setHeader("value_B", msgListIn.get(1).toString());
		inMessage.setHeader(CxfConstants.OPERATION_NAMESPACE, "http://bsg.gob.ec/AccesoBSGService");
	}

}
