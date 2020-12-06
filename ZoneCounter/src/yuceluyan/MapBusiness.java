package yuceluyan;

public class MapBusiness implements MapInterface{
	@Override
	public void SetSize(Dimension dim) {
		MapOperations.mapArray = new String[dim.width][dim.height];
	}

	@Override
	public void GetSize(Dimension dim) {
		MapOperations.width = MapOperations.mapArray.length;
		MapOperations.height = MapOperations.mapArray[0].length;
	}

	@Override
	public void SetBorder(int x, int y) throws Exception {
		MapOperations.mapArray[x][y]=MapOperations.border;

	}

	@Override
	public void ClearBorder(int x, int y) throws Exception {
		MapOperations.mapArray[x][y]=MapOperations.clearBorder;
	}

	@Override
	public boolean IsBorder(int x, int y) throws Exception {

		if (x<0||y<0||y>=MapOperations.height||x>=MapOperations.width) 
		{
			return true;
		}
		if (MapOperations.mapArray[x][y]==MapOperations.border) 
		{
			return true;
		}
		return false;
	}

	@Override
	public void Show() {
		for(int i=0; i<MapOperations.height; i++){
			for(int j=0; j<MapOperations.width; j++) {
				if (MapOperations.mapArray[j][i]!=MapOperations.border) {
					MapOperations.mapArray[j][i]= MapOperations.zone;
				}
				System.out.print(MapOperations.mapArray[j][i]);
			}
			System.out.println();
		}
	}
}
