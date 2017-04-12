package xx.WebSocket;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class ClientEndPoint {

	Session session = null;
	private MessageHandler messageHandler;

	// constructor
	public ClientEndPoint(URI endpointURI) {
		// A WebSocketContainer is an implementation provided object that
		// provides applications a view on the container running it.
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		try {
			container.connectToServer(this, endpointURI);
		} catch (DeploymentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// callback hook for connection open events
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("opening websocket");
		this.session = session;
	}

	// callback hook for connection close events
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("closing websocket");
		this.session = null;
	}

	// callback hook for Message Events
	// This method will be invoked when a client send a message.
	@OnMessage
	public void onMessage(String message) {
		System.out.println(message);
		if (this.messageHandler != null) {
			this.messageHandler.handleMessage(message);
		}
	}

	// register message handler
	public void addMessagehandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	// send message
	public void sendMessage(String message) {
		this.session.getAsyncRemote().sendText(message);
	}

	// Message Handler
	public static interface MessageHandler {
		public void handleMessage(String message);
	}
}
