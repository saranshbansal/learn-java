package com.scratchpad;


import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

public class NestedList {

    private static List<GartnerMCPDto> findUpdatedMCPs(List<GartnerMCPDto> newList, List<GartnerMCPDto> oldList) {
        List<GartnerMCPDto> filteredList;
        if (isEmpty(oldList)) {
            filteredList = newList;
        } else {
            List<GartnerMCPDto> list = new ArrayList<>(newList);
            list.removeAll(oldList); //list contains items only in name

            List<GartnerMCPDto> list2 = new ArrayList<>(oldList);
            list2.removeAll(newList); //list2 contains items only in name2

            list2.addAll(list); //list2 now contains all the not-common items
            filteredList = list2;
        }
        return filteredList;
    }


    public static void main(String[] args) {
        List<GartnerMCPDto> newList = new ArrayList<>();
        List<GartnerMCPDto> oldList = new ArrayList<>();
        GartnerMCPDto mcp1 = new GartnerMCPDto("1", "a");
        GartnerMCPDto mcp2 = new GartnerMCPDto("1", "a");
        GartnerMCPDto mcp3 = new GartnerMCPDto("3", "abc");
        GartnerMCPDto mcp4 = new GartnerMCPDto("3", "abc");
        GartnerMCPDto mcp5 = new GartnerMCPDto("2", "b");
        GartnerMCPDto mcp6 = new GartnerMCPDto("4", "d");

        oldList.add(mcp1);
        oldList.add(mcp3);
        oldList.add(mcp6);
        newList.add(mcp2);
        newList.add(mcp4);
        newList.add(mcp5);

        List<GartnerMCPDto> filteredList = findUpdatedMCPs(newList, oldList);
        for (GartnerMCPDto filteredMcp : filteredList) {
            System.out.println(filteredMcp.getId() + "---" + filteredMcp.getName());
        }
    }

}


class GartnerMCPDto {
    String id;
    String name;


    public GartnerMCPDto(String id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GartnerMCPDto other = (GartnerMCPDto) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

}
