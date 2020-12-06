package yuceluyan;

public class MapOperations implements ZoneCounterInterface{
	public static  String[][] mapArray;
	public static int width;
	public static int height;
	public static String[] cells;
	public static String border="1";
	public static String zone="0";
	public static String clearBorder="C";
	MapBusiness mb = new MapBusiness();

	@Override
	public void Init(MapInterface map) throws Exception {

		Dimension d = new Dimension(36, 24);
		map.SetSize(d);
		map.GetSize(d);
		map.SetBorder(12,0);
		map.SetBorder(12,1);
		map.SetBorder(11,2);
		map.SetBorder(11,3);
		map.SetBorder(10,4);
		map.SetBorder(10,5);
		map.SetBorder(10,6);
		map.SetBorder(9,6);
		map.SetBorder(9,7);
		map.SetBorder(8,8);
		map.SetBorder(8,9);
		map.SetBorder(6,12);
		map.SetBorder(7,10);
		map.SetBorder(7,11);
		map.SetBorder(6,11);
		map.SetBorder(7,10);
		map.SetBorder(5,13);
		map.SetBorder(4,13);
		map.SetBorder(3,12);
		map.SetBorder(2,11);
		map.SetBorder(1,10);
		map.SetBorder(0,10);
		map.SetBorder(5,14);
		map.SetBorder(29,10);
		map.SetBorder(29,9);
		map.SetBorder(29,8);
		map.SetBorder(30,7);
		map.SetBorder(30,6);
		map.SetBorder(31,5);
		map.SetBorder(31,4);
		map.SetBorder(11,6);
		map.SetBorder(12,6);
		map.SetBorder(13,7);
		map.SetBorder(14,7);
		map.SetBorder(15,7);
		map.SetBorder(16,7);
		map.SetBorder(12,6);
		map.SetBorder(17,8);
		map.SetBorder(18,8);
		map.SetBorder(19,8);
		map.SetBorder(20,8);
		map.SetBorder(21,9);
		map.SetBorder(22,9);
		map.SetBorder(23,9);
		map.SetBorder(24,9);
		map.SetBorder(25,10);
		map.SetBorder(26,10);
		map.SetBorder(27,10);
		map.SetBorder(28,10);
		map.SetBorder(29,10);
		map.SetBorder(6,14);
		map.SetBorder(7,15);
		map.SetBorder(8,16);
		map.SetBorder(9,16);
		map.SetBorder(10,17);
		map.SetBorder(11,18);
		map.SetBorder(12,19);
		map.SetBorder(13,19);
		map.SetBorder(14,20);
		map.SetBorder(15,21);
		map.SetBorder(16,22);
		map.SetBorder(17,22);
		map.SetBorder(18,23);
		map.SetBorder(31,3);
		map.SetBorder(32,2);
		map.SetBorder(32,1);
		map.SetBorder(33,0);
		map.SetBorder(28,11);
		map.SetBorder(28,12);
		map.SetBorder(27,13);
		map.SetBorder(27,14);
		map.SetBorder(27,15);
		map.SetBorder(26,16);
		map.SetBorder(27,17);
		map.SetBorder(26,18);
		map.SetBorder(25,19);
		map.SetBorder(25,20);
		map.SetBorder(24,21);
		map.SetBorder(24,22);
		map.SetBorder(24,23);
		map.SetBorder(27,17);
		map.SetBorder(28,17);
		map.SetBorder(29,17);
		map.SetBorder(30,17);
		map.SetBorder(31,17);
		map.SetBorder(32,17);
		map.SetBorder(33,17);
		map.SetBorder(34,17);
		map.SetBorder(35,18);

		map.Show();
	}

	@Override
	public int Solve() throws Exception {
		if (mapArray==null) {
			return 0;
		}

		cells = new String[height*width];
		int zoneCounter=0;
		for(int i = 0; i < width; ++i) {
			for(int j = 0; j < height; ++j) {
				cells[j * width + i] = "Unexplored";
			}
		}

		for(int i = 0; i < width; ++i) {
			for(int j = 0; j < height; ++j) {
				if(!mb.IsBorder(i, j) && cells[j * width + i]!="Explored") {
					ExploreNeighborCells(i, j, width, height, cells);
					zoneCounter++;
				}
			}
		}

		return zoneCounter;
	}
	void ExploreNeighborCells(int x, int y, int width, int height, String cells[]) throws Exception {

		if (x < 0 || y < 0) {
			return;
		}
		if(!mb.IsBorder(x, y) && cells[y * width + x]!="Explored" && x >= 0 && y >= 0 && x < width && y < height)
		{
			cells[y * width + x] = "Explored";
			ExploreNeighborCells(x - 1, y    , width, height, cells);
			ExploreNeighborCells(x + 1, y    , width, height, cells);
			ExploreNeighborCells(x    , y - 1, width, height, cells);
			ExploreNeighborCells(x    , y + 1, width, height, cells);
		}
	}
}
