package org.jcollectd.agent.api;

import org.jcollectd.agent.protocol.TypesDB;

import java.util.ArrayList;
import java.util.List;

public class Values extends AbstractPacket<List<Number>> {
    private List<Number> _values = new ArrayList<Number>();
    private final List<DataSource> _ds;

    public Values(Identifier identifier) {
        super(identifier);
        _ds = TypesDB.getInstance().getType(identifier.getType());
    }

    public Values(Identifier identifier, List<Number> values) {
        this(identifier);
        _values.addAll(values);
    }

    @Override
    public List<Number> getData() {
        return _values;
    }

    public void addValue(Number value) {
        _values.add(value);
    }

    public List<DataSource> getDataSource() {
        if (_ds.size() > 0) {
            return _ds;
        } else {
            return null;
        }
    }



    @Override
    public String toString() {
        return "Values [_values=" + _values + ", _ds=" + _ds + ", getInterval()=" + getInterval() + ", getTime()=" + getTime()
                + ", getHost()=" + getHost() + ", getPlugin()=" + getPlugin() + ", getPluginInstance()=" + getPluginInstance()
                + ", getType()=" + getType() + ", getTypeInstance()=" + getTypeInstance() + ", getSource()=" + getSource() + "]";
    }

    public void clearValues() {
            _values.clear();
    }

    public void addValue(String s) {
        try{
            addValue(Integer.parseInt(s));
        }
        catch (NumberFormatException e){
            addValue(Double.parseDouble(s));
        }
    }

    public void addValues(List<Number> values) {
        _values.addAll(values);
    }
}
