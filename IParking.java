package git;
import java.util.ArrayList;
public interface IParking {
	public void print(ArrayList<Integer> plan);
	public boolean addCar(Integer carType);
	public String[] parse(String s)throws Exception;
}
