/*
Quoc Le
COP 3503-0001
SingletonDm
11 April 2016
*/
import java.util.*;

public class SingletonDM 
 {
	//Here, put the specific private static variable that makes this class follow the singleton pattern.
	private static SingletonDM firstInstance = null;
	//The array of randomized character sheets.
	//Feel free to hardcode a few of these for your testing.
	private PlayerCharacter sheets[] = 
	{
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter(), 
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter(), 
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter(),
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter(), 
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter(), 
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter(), 
		new PlayerCharacter(), new PlayerCharacter(), new PlayerCharacter()
	};
	
	//The sheets array remade as a list for convenience.
	private LinkedList<PlayerCharacter> sheetList = new LinkedList<PlayerCharacter>(Arrays.asList(sheets));
	
	//Here, put the specific kind of constructor that makes this class follow the singleton pattern.
	static boolean firstThread = true;
	public static SingletonDM getInstance()
	{
		//This will act as the "true" constructor for this class.
		//Its details should include but not be limited to the following:
		//		- Check if this is the first thread.
		//		- Check the private static variable at the top of the class.
		//		- Have the "synchronized" key word in there somewhere.
		//		- Return some kind of SingletonDM
		if (firstInstance == null)
		{
			if(firstThread)//if the Thread is the first thread, pause for a second
			{
				firstThread = false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			synchronized (SingletonDM.class) { //synchronized each list
				if (firstInstance == null)
				{
					firstInstance = new SingletonDM();
				}
			}			
		}
			
		
		return firstInstance;
	}
	
	public String GetNameAndPID()
	{
		return( "Le,Quoc,3455489");
		//Please replace Last, First, and PID with your relevant details.
		//This function will be called in main.
	}
	
	public LinkedList<PlayerCharacter> getSheetList()
	{
		//Pretty self-explanatory.
		return firstInstance.sheetList;
	}
	
	public LinkedList<PlayerCharacter> getSheetsOfLevel(int level)
	{
		//This should find all characters of a certain level in the list, and return them in a separate list.
		//Note: do not remove these characters from the list itself!
		//Just find them and put them in their own list, then return that list.
		LinkedList<PlayerCharacter> temp = new LinkedList<PlayerCharacter>();
		for (int i = 0; i < firstInstance.sheetList.size(); i++)//Check each element in the list to find the level
		{
			if (firstInstance.sheetList.get(i).getLevel() == level)
				temp.add(firstInstance.sheetList.get(i));
		}
		return temp;
		
	}
	
	public LinkedList<PlayerCharacter> getSheetsOfType(String type)
	{
		//This should find all characters of a certain type in the list, and return them in a separate list.
		//Note: do not remove these characters from the list itself!
		//Just find them and put them in their own list, then return that list.
		LinkedList<PlayerCharacter> temp = new LinkedList<PlayerCharacter>();//Check each element in the list to find the type
		for (int i = 0; i < firstInstance.sheetList.size(); i++)
		{
			if (firstInstance.sheetList.get(i).gettype() == type)
				temp.add(firstInstance.sheetList.get(i));
		}
		return temp;
	}
}
