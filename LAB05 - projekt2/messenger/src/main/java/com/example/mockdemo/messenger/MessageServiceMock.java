package com.example.mockdemo.messenger;

public class MessageServiceMock implements MessageService {

	private boolean sending = false;
	private boolean connected = false;

	public void setConnection(boolean status) {
		connected = status;
	}

	public void setMessageStatus(boolean status) {
		sending = status;
	}

	@Override
	public ConnectionStatus checkConnection(String server) {
		if (connected == true && server != null && server.endsWith(".pl"))
			return ConnectionStatus.SUCCESS;
		else
			return ConnectionStatus.FAILURE;
	}

	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		if (server == null || message == null)
			throw new MalformedRecipientException();
		if (server.length() < 4 || message.length() < 3)
			throw new MalformedRecipientException();
		if (sending)
			return SendingStatus.SENT;

		return SendingStatus.SENDING_ERROR;
	}

}
