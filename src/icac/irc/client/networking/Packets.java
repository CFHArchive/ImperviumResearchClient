package icac.irc.client.networking;


public enum Packets {
	
	ProtocolVersion(0, "Protocol Version"),
	ConnectionResponse(1, "Connection Response"),
	DisconnectResponse(2, "Disconnect Response"),
	HandshakeChallenge(3, "Handshake Challenge"),
	ChatRecieved(4, "Chat Recieved"),
	UniverseTimeUpdate(5, "Universe Time Update"),
	CelestialResponse(6, "Celestial Response"),
	ClientConnect(7, "Client Connect"),
	ClientDisconnect(8, "Client Disconnect"),
	HandshakeResponse(9, "Handshake Response"),
	WarpCommand(10, "Warp Command"),
	ChatSent(11, "Chat Sent"),
	CelestialRequest(12, "Celestial Request"),
	ClientContextUpdate(13, "Client Context Update"),
	WorldStart(14, "World Start"),
	WorldStop(15, "World Stop"),
	TileArrayUpdate(16, "Tile Array Update"),
	TileUpdate(17, "Tile Update"),
	TileLiquidUpdate(18, "Tile Liquid Update"),
	TileDamageUpdate(19, "Tile Damage Update"),
	TileModificationFailure(20, "Tile Modification Failure"),
	GiveItem(21, "GiveItem"),
	SwapinContainerResult(22, "Swapin Container Result"),
	EnvironmentUpdate(23, "Environment Update"),
	EntityInteractResult(24, "Entity Interact Result"),
	ModifyTileList(25, "Modify Tile List"),
	DamageTile(26, "Damage Tile"),
	DamageTileGroup(27, "Damage Tile Group"),
	RequestDrop(28, "Request Drop"),
	SpawnEntity(29, "Spawn Entity"),
	EntityInteract(30, "Entity Interact"),
	ConnectWire(31, "Connect Wire"),
	DisconnectAllWires(32, "Disconnect All Wires"),
	OpenContainer(33, "Open Container"),
	CloseContainer(34, "Close Container"),
	SwapinContainer(35, "Swap in Container"),
	ItemApplyinContainer(36, "Item Apply in Container"),
	StartCraftinginContainer(37, "Start Crafting in Container"),
	StopCraftinginContainer(38, "Stop Crafting in Container"),
	BurnContainer(39, "Burn Container"),
	ClearContainer(40, "Clear Container"),
	WorldClientStateUpdate(41, "World Client State Update"),
	EntityCreate(42, "Entity Create"),
	EntityUpdate(43, "Entity Update"),
	EntityDestroy(44, "Entity Destroy"),
	DamageNotification(45, "Damage Notification"),
	StatusEffectRequest(46, "Status Effect Request"),
	UpdateWorldProperties(47, "Update World Properties"),
	Heartbeat(48, "Heartbeat");
	
	
	int id;
	String name;
	
	Packets(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static String getName(int id) {
		for(Packets p : values()){
	        if(p.id == id) {
	        	return p.name;
	        }
	    }
		return "unknown";
	}
	
	public static int getID(String name) {
		for(Packets p : values()){
	        if(p.name.equals(name)) {
	        	return p.id;
	        }
	    }
		return -1;
	}
}