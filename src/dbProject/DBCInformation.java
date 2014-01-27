package dbProject;

public class DBCInformation {
	private String addressServer,portServer,dataBaseName,user,password;
	
	public DBCInformation() {
		this.addressServer="localhost";
		this.portServer="1521";
		this.dataBaseName="orcl";
		this.user="c##DBproject";
		this.password="password";
	}
	public DBCInformation(String addressServer,String portServer,String dataBaseName,String user,String password){
		this.addressServer=addressServer;
		this.portServer=portServer;
		this.dataBaseName=dataBaseName;
		this.user=user;
		this.password=password;
	}
	
	public String getAddressServer(){return this.addressServer;}
	public String getPortServer(){return this.portServer;}
	public String getDataBaseName(){return this.dataBaseName;}
	public String getUser(){return this.user;}
	public String getPassword(){return this.password;}
	
	public void setAddressServer(String addressServer){this.addressServer=addressServer;}
	public void setPortServer(String portServer){this.portServer=portServer;}
	public void setDataBaseName(String dataBaseName){this.dataBaseName=dataBaseName;}
	public void setUser(String user){this.user=user;}
	public void setPassword(String password){this.password=password;}
	
	public String toString(){
		String str;
	    if(this.addressServer != null && this.portServer != null && this.user != null && this.password != null){
	    	str = "Description des informations de la connexion\n\n";
	    	str += "Address server : " + this.addressServer+ "\n";
	    	str += "DataBase Name : " + this.dataBaseName+ "\n";
	    	str += "Port Server : " + this.portServer + "\n";
	    	str += "User Name : " + this.user + "\n";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	}
}
