
public class Trainer{
	String name;
	String gender;
	Pokemon Starter;
	
	public Trainer(String new_name, String new_gender, Pokemon new_Starter) {
		name = new_name;
		gender = new_gender; 
		Starter = new_Starter; 
	}

	public String toString(){
		System.out.println("\nTrainer name : " + name + "\nTrainer gender: " + gender + "\n");
		System.out.println(Starter.toString());
		return "";
	}
}
