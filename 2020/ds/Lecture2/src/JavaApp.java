
public class JavaApp {
	public static void main(String[] args) {		
		ArrayList<String> list = new ArrayList<String>();
		list.append("apple");
		list.append("orange");
		list.append("banana");
		list.append("tomato");
		System.out.println("Current Array Size is "+list.GetSize());
		SList<String> slist = new SList<String>();
		slist.insert("apple");
		slist.insert("orange");
		slist.insert("banana");
		slist.insert("tomato");
		slist.show();
		slist.remove();
		slist.show();
	}
}
