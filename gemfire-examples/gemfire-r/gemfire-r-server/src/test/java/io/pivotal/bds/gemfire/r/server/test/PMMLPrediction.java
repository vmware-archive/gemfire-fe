package io.pivotal.bds.gemfire.r.server.test;

import java.util.Random;

import org.json.JSONObject;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.JSONFormatter;
import com.gemstone.gemfire.pdx.PdxInstance;

public class PMMLPrediction {

    private static final Random random = new Random();
    private static final String[] employments = { "Private", "Consultant", "SelfEmp", "PSLocal", "PSState", "PSFederal",
            "Unemployed", "HSgrad", "Volunteer" };
    private static final String[] educations = { "College", "Associate", "HSgrad", "Bachelor", "Yr10", "Yr11", "Yr12", "Vocational",
            "Master" };
    private static final String[] maritals = { "Unmarried", "Absent", "Divorced", "Married", "Widowed" };
    private static final String[] occupations = { "Service", "Transport", "Clerical", "Repair", "Executive", "Machinist", "Sales",
            "Professional", "Support" };
    private static final String[] genders = {"Female","Male"};
    private static final String[] accounts = {"UnitedStates","Jamaica","Mexico","Cuba"};

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("192.168.0.110", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        ClientRegionFactory<Integer, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<Integer, PdxInstance> r = crf.create("auditData");

        for (int i = 0; i < 10; ++i) {
            JSONObject jo = new JSONObject();

            int id = 10000000 + i;

            jo.put("ID", id);

            putInt(jo, "Age", 20, 80);
            putString(jo, "Employment", employments);
            putString(jo, "Education", educations);
            putString(jo, "Marital", maritals);
            putString(jo, "Occupation", occupations);
            putInt(jo, "Income", 30000, 100000);
            putString(jo, "Gender", genders);
            putInt(jo, "Deductions", 0, 3);
            putInt(jo, "Hours", 30, 70);
            putString(jo, "IGNORE_Accounts", accounts);
            putInt(jo, "RISK_Adjustment", 0, 10000);
            putInt(jo, "TARGET_Adjusted", 0, 1);

            PdxInstance inst = JSONFormatter.fromJSON(jo.toString());
            r.put(id, inst);
        }
    }

    private static int getInt(int min, int max) {
        return min + random.nextInt(max - min);
    }

    private static void putString(JSONObject obj, String name, String[] values) {
        int i = random.nextInt(values.length);
        String val = values[i];
        obj.put(name, val);
    }

    private static void putInt(JSONObject obj, String name, int min, int max) {
        int t = getInt(min, max);
        obj.put(name, t);
    }

}
