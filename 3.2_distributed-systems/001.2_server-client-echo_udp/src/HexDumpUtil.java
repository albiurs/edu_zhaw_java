/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.UnsupportedEncodingException;

public final class HexDumpUtil {
	/** Prints a byte array in a pretty hex dump format
	 * 
	 * @param array byte array
	 * @param offset starting position
	 * @param length length of array to print
	 * @return
	 */
	public static String formatHexDump(byte[] array, int offset, int length) {
		final int width = 16;

		StringBuilder builder = new StringBuilder();

		for (int rowOffset = offset; rowOffset < offset + length; rowOffset += width) {
			builder.append(String.format("%06d:  ", rowOffset));

			for (int index = 0; index < width; index++) {
				if (rowOffset + index < array.length) {
					builder.append(String.format("%02x ", array[rowOffset + index]));
				} else {
					builder.append("   ");
				}
			}

			if (rowOffset < array.length) {
				int asciiWidth = Math.min(width, array.length - rowOffset);
				builder.append("  |  ");
				try {
					builder.append(
							new String(array, rowOffset, asciiWidth, "ISO-8859-1").replaceAll("\r\n", " ").replaceAll("\n", " "));
				} catch (UnsupportedEncodingException ignored) {

				}
			}

			builder.append(String.format("%n"));
		}

		return builder.toString();
	}
}