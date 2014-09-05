package ec.se.example.fuse.ws;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

import ec.gob.bsg.accesobsgservice.RetornoOne;

public class ProccesorTwo implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
		MessageContentsList msgListIn = (MessageContentsList)inMessage.getBody();
		RetornoOne retorno = (RetornoOne)msgListIn.get(0); 
		List<String> params = new ArrayList<String>();
		params.add(inMessage.getHeader("value_B").toString());
		params.add(retorno.getX());
		params.add(retorno.getY());
		inMessage.setBody(params,ArrayList.class);
		inMessage.setHeader(CxfConstants.OPERATION_NAMESPACE, "http://sri.gob.ec/wsConsultaEstablecimientos");
	}

}
