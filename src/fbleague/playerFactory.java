package fbleague;

public class playerFactory {

	@SuppressWarnings("unused")
	public Player makePlayer(String position)
	{
		Player newPlayer = null;
		if (position.equals("Goalkeeper"))
		{
		    return new Goalkeeper();
		}
		else if(position.equals("Forward Player"))
		{
			return new forwardPlayer();
		}
		else if(position.equals("Defender"))
		{
			return new defender();
		}
		else if(position.equals("Midfielder"))
		{
			return new midfielder();
		}
		else return null;

	}

}
