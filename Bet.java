import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple betting calculator that allows the user to place a bet with american
 * odds and see the payout.
 *
 * @author William DeNiro
 */
public final class Bet {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Bet() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        out.println("Enter your stake in $");
        double stake = in.nextInteger();
        out.println("Enter the odds (ex : +200 or -200)");
        String odds = in.nextLine();
        String stringodds = odds.substring(1, odds.length());
        double odd = Double.parseDouble(stringodds);
        double winnings;
        ;
        if (odds.charAt(0) == '-') {

            stake = stake * 100;

            winnings = stake / odd;
            stake = stake / 100;
            out.println("To Win ($):  " + "$" + winnings);
            out.print("Payout:  " + "$");
            out.print(stake + winnings);
        } else {

            stake = odd * stake;

            winnings = stake / 100;
            stake = stake / odd;
            out.println("To Win ($): " + "$" + winnings);
            out.print("Payout:  " + "$");
            out.print(stake + winnings);
        }

        out.close();
        in.close();
    }
}
