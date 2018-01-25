

public class ThreeProductChallenge{

	public boolean notFull = true;
	public int[] newList = new int[3];

	public int[] list = {0 , 23, 45, 60, -10, -2, -200, 40, 20};
	public int focus = list[0];


	//int[] b = findTopThreeNumbers();

	public int[] findTopThreeNumbers(){
		while(notFull){
			for(int i =1; i< list.length; i++){
				if(focus <= list[i]){
					focus = list[i];
					list[i] = 0;
				}
			}
			if(!checkFullness()){
				notFull = false;

			}
			
		}
		//turn newList;
		System.out.println(newList);
		return newList;
	}

	public boolean checkFullness(){
		for(int m = 0; m<3; m ++){
			if(newList[m] == 0){
				return true;
			}
		}
		return false;
	}

}
