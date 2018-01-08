package strathmore.com.ebus;

/**
 * Created by mambo on 21/10/2017.
 */

public class EmptyItem extends AbstractItem {

    public EmptyItem(String label) {
        super(label);
    }


    @Override
    public int getType() {
        return TYPE_EMPTY;
    }

}