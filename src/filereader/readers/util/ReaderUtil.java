package filereader.readers.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import filereader.util.maths.Vector3f;

public class ReaderUtil {

	public static List<String> readStringChunk(ByteBuffer buff, int chunksDataStart, int chunkSize) {

		List<String> data = new ArrayList<String>();
		StringBuilder str = new StringBuilder();

		for (int i = chunksDataStart; i < chunksDataStart + chunkSize; i++) {
			if (buff.get(i) != 0) {
				str.append((char) buff.get(i));
			} else {
				data.add(new String(str));
				str = new StringBuilder();
				i++;
				str.append((char) buff.get(i));
			}
		}
		return data;
	}
	
	public static int getChunkSize(byte[] allBytes, int chunkStart, int sizeBit) {
		ByteBuffer dataBuff = ByteBuffer.allocate(4);
		dataBuff.order(ByteOrder.LITTLE_ENDIAN);
		
		dataBuff.put(allBytes, chunkStart - sizeBit, 4);
		dataBuff.position(0);
		
		return dataBuff.getInt();
	}
	
	public static Vector3f createVector3f(ByteBuffer dataBuff, int offset) {
		Vector3f vec = new Vector3f();

		vec.setX(readFloat4Bytes(dataBuff, offset));
		offset += 4;

		vec.setY(readFloat4Bytes(dataBuff, offset));
		offset += 4;

		vec.setZ(readFloat4Bytes(dataBuff, offset));
		offset += 4;

		return vec;
	}

	public static int readInt4Bytes(ByteBuffer dataBuff, int offset) {

		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.order(ByteOrder.LITTLE_ENDIAN);

		buff.put(dataBuff.get(offset));
		buff.put(dataBuff.get(offset + 1));
		buff.put(dataBuff.get(offset + 2));
		buff.put(dataBuff.get(offset + 3));
		buff.position(0);

		return buff.getInt();
	}

	public static float readFloat4Bytes(ByteBuffer dataBuff, int offset) {

		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.order(ByteOrder.LITTLE_ENDIAN);

		buff.put(dataBuff.get(offset));
		buff.put(dataBuff.get(offset + 1));
		buff.put(dataBuff.get(offset + 2));
		buff.put(dataBuff.get(offset + 3));
		buff.position(0);

		return buff.getFloat();
	}

	public static short readInt2Bytes(ByteBuffer dataBuff, int offset) {
		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.order(ByteOrder.LITTLE_ENDIAN);

		buff.put(dataBuff.get(offset));
		buff.put(dataBuff.get(offset + 1));
		buff.position(0);

		return buff.getShort();
	}

	public static short readByte(ByteBuffer dataBuff, int offset) {
		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.order(ByteOrder.LITTLE_ENDIAN);

		buff.put(dataBuff.get(offset));
		buff.position(0);

		return buff.get();
	}

	public static ByteBuffer createByteBuffer(byte[] allBytes) {
		ByteBuffer buff = ByteBuffer.allocate(allBytes.length);
		buff.put(allBytes);
		buff.order(ByteOrder.LITTLE_ENDIAN);
		return buff;
	}

	

	

}