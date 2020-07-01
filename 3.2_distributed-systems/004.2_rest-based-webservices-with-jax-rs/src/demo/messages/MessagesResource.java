/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package demo.messages;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/messages")
public class MessagesResource {
	private static Map<Integer, Message> messages;
	private static int count;

	static {
		messages = new ConcurrentHashMap<Integer, Message>();
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response newMessage1(@Context UriInfo info, String text) {
		int id = getId();
		Message message = new Message(id, getTimestamp(), text);
		messages.put(id, message);
		URI location = info.getAbsolutePathBuilder().path(String.valueOf(id))
				.build();
		return Response.created(location).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response newMessage2(@Context UriInfo info,
			@FormParam("text") String text) {
		int id = getId();
		Message message = new Message(id, getTimestamp(), text);
		messages.put(id, message);
		URI location = info.getAbsolutePathBuilder().path(String.valueOf(id))
				.build();
		return Response.created(location)
				.status(Response.Status.MOVED_PERMANENTLY).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response updateMessage(@PathParam("id") int id, String text) {
		Message message = messages.get(id);
		if (message == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		} else {
			message.setTimestamp(getTimestamp());
			message.setText(text);
			messages.put(id, message);
			return Response.noContent().status(Response.Status.OK).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response deleteMessage(@PathParam("id") int id) {
		if (messages.get(id) != null) {
			messages.remove(id);
			return Response.noContent().status(Response.Status.OK).build();
		} else {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
	}

	@DELETE
	public void deleteAllMessages() {
		messages.clear();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessageJson(@PathParam("id") int id) {
		Message message = messages.get(id);
		if (message == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"message id\": " + message.getId() + ",");
		sb.append("\"timestamp\": \"" + message.getTimestamp() + "\",");
		sb.append("\"text\": \"" + message.getText() + "\"");
		sb.append("}");
		return Response.ok(sb.toString()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMessagesJson() {
		Object[] values = messages.values().toArray();
		Arrays.sort(values);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < values.length; i++) {
			Message message = (Message) values[i];
			if (i>0) 
				sb.append(",");
			sb.append("{");
			sb.append("\"message id\": " + message.getId() + ",");
			sb.append("\"timestamp\": \"" + message.getTimestamp() + "\",");
			sb.append("\"text\": \"" + message.getText() + "\"");
			sb.append("}");
		}
		sb.append("]");
		return Response.ok(sb.toString()).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getMessageXml(@PathParam("id") int id) {
		Message message = messages.get(id);
		if (message == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<message id=\"" + message.getId() + "\">");
		sb.append("<timestamp>" + message.getTimestamp() + "</timestamp>");
		sb.append("<text>" + message.getText() + "</text>");
		sb.append("</message>");
		return Response.ok(sb.toString()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllMessagesXml() {
		Object[] values = messages.values().toArray();
		Arrays.sort(values);
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<messages>");
		for (int i = 0; i < values.length; i++) {
			Message message = (Message) values[i];
			sb.append("<message id=\"" + message.getId() + "\">");
			sb.append("<timestamp>" + message.getTimestamp() + "</timestamp>");
			sb.append("<text>" + message.getText() + "</text>");
			sb.append("</message>");
		}
		sb.append("</messages>");
		return Response.ok(sb.toString()).build();
	}
	
	private synchronized static int getId() {
		return ++count;
	}

	private static String getTimestamp() {
		return new Timestamp(System.currentTimeMillis()).toString();
	}
}
