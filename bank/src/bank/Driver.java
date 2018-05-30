package bank;



public class Driver {
	public static void parse(String s) {
		String[] fileI = s.split(",");
		System.out.println("Name: " + fileI[0] );
		System.out.println("ID: " + fileI[1]);
		System.out.println("Balance: " + fileI[2]);
	}
	
	public static void main(String[] args) {
	
		CustomerAccount cust = new CustomerAccount("Tom","2234a");
		cust.menu();
		
		
//		option = scan.nextInt();
//		switch (option) {
//		case 1:
//			
//			System.out.println("Enter your Name: ");
//			String name = scan.next();
//			System.out.println("Enter your username: ");
//			String id =scan.next();
//			System.out.println("Make a deposit");
//			
//			double balance = scan.nextDouble();
//			
//			
//			
//			
//			
//			Customer cus1 = new Customer(name, id, balance);
//			
//			 cus1.setBalance(balance);
//			
//			BufferedWriter bw = null;
//			String path = "src/bank/data.txt";
//			
//			String content = cus1.toString();
//			
//			try {
//				File file = new File(path);
//				if(!file.exists()) {
//				file.createNewFile();
//				}
//				//our filewriter has an optional argument that specifies appending. defaults to false.
//				FileWriter fw = new FileWriter(file , true);
//				bw = new BufferedWriter(fw);
//				
//				bw.write(content);
//				System.out.println("Customer Id created");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				if(bw != null) {
//					try {
//						bw.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		
//			break;
//		case 2:
//			BufferedReader br = null;
//			
//			String path2 = "src/bank/data.txt";
//			
//			try {
//				br = new BufferedReader(new FileReader(path2));
//				String line = br.readLine();
//				
//				while(line != null) {
//					parse(line);
//					line = br.readLine();
//				}
//				
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			break;
//		case 3:
//			System.out.println();
//			break;
//			
//		case 4:
//			System.out.println();
//			break;
//			
//		default:
//			break;
//		}
//		
		
	}
}
