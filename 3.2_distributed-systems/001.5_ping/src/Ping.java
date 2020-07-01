/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 * Shows the availability of a host. 
 *
 */
public class Ping {
  /**
   * Called at program start.
   * @param args host
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java -cp bin Ping <host>");
      System.exit(1);
    }

    try {
      InetAddress address = InetAddress.getByName(args[0]);
      JOptionPane.showMessageDialog(null, String.format("%s/%s pingable? %s%n", address.getHostName(),
          address.getHostAddress(), address.isReachable(5000)), "Ping", JOptionPane.PLAIN_MESSAGE);
    } catch (Exception e) {
      // Do nothing if something goes wrong
    }
  }
}
