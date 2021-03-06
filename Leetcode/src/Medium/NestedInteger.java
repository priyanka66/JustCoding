package Medium;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList<>();
            this.list.add(nestedInteger);
        }
    }



}
