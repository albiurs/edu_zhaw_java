/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package demo.messages;

public class Message implements Comparable<Message> {
	private int id;
	private String timestamp;
	private String text;

	public Message() {
	}

	public Message(String text) {
		this.text = text;
	}

	public Message(int id, String timestamp, String message) {
		this.id = id;
		this.timestamp = timestamp;
		this.text = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", timestamp=" + timestamp + ", text="
				+ text + "]";
	}
	
	@Override
	public int compareTo(Message message) {
		return Integer.valueOf(id)
				.compareTo(Integer.valueOf(message.id));
	}
}
