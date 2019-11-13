
public class MostBookedHotelRoomOA {
	public String mostBookedRoom(String[] records) {
		int[][] table = new int[10][26];
		int maxFloor = 0;
		int maxRoom = 0;
		for(String record : records) {
			if(record.startsWith("-")) {
				continue;
			}
			int currentFloor = record.charAt(1) - '0';
			int currentRoom = record.charAt(2) - 'A';
			table[currentFloor][currentRoom]++;
			if(currentFloor == maxFloor && currentRoom == maxRoom) {
				continue;
			}
			if(table[currentFloor][currentRoom] > table[maxFloor][maxRoom]) {
				maxFloor = currentFloor;
				maxRoom = currentRoom;
			}else if(table[currentFloor][currentRoom] == table[maxFloor][maxRoom]) {
				if(currentFloor * 26 + currentRoom < maxFloor * 26 + maxRoom) {
					maxFloor = currentFloor;
					maxRoom = currentRoom;
				}
			}
		}
		return "" + maxFloor + (char)(maxRoom + 'A');
	}
}
