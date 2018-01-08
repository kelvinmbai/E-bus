package strathmore.com.ebus;

/**
 * Created by mambo on 21/10/2017.
 */

public class EdgeItem extends AbstractItem {

    public EdgeItem(String label) {
        super(label);
    }



    @Override
    public int getType() {
        return TYPE_EDGE;
    }

}
