import java.text.Format;
import java.util.regex.Pattern;

public class Account implements OnlineAccount, Comparable<Account>{
    private int noOfRegularMovies;
    private int noOfExclusiveMovies;
    private int ownerName;
    private int monthlyCost;

    public Account(int noOfRegularMovies, int noOfExclusiveMovies, int ownerName) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
        this.monthlyCost = basePrice + noOfRegularMovies*regularMoviePrice + noOfExclusiveMovies*exclusiveMoviePrice;
    }

    public int monthlyCost(){
        return this.monthlyCost;
    }

    @Override
    public int compareTo(Account account) {
        return this.monthlyCost - account.monthlyCost();
    }

    @Override
    public String toString() {
        String message = "Owner is %s and monthly cost is %s USD.";
        return String.format(message, this.ownerName, this.monthlyCost);
    }
}
