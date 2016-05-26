package playground.solrmarc.index.extractor.formatter;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import org.marc4j.marc.VariableField;

public interface FieldFormatter
{

    public final static EnumSet<eCleanVal> TITLE_SORT_UPPER = EnumSet.of(eCleanVal.CLEAN_EACH, eCleanVal.STRIP_ACCCENTS,
            eCleanVal.STRIP_ALL_PUNCT, eCleanVal.TO_UPPER, eCleanVal.STRIP_INDICATOR_2);
    public final static EnumSet<eCleanVal> TITLE_SORT_LOWER = EnumSet.of(eCleanVal.CLEAN_EACH, eCleanVal.STRIP_ACCCENTS,
            eCleanVal.STRIP_ALL_PUNCT, eCleanVal.TO_LOWER, eCleanVal.STRIP_INDICATOR_2);

    public static StringBuilder buffer = new StringBuilder();
    public static List<String> emptyList = Collections.emptyList();

    public enum eJoinVal
    {
        SEPARATE, JOIN;
    };

    public enum eCleanVal
    {
        CLEAN_END, CLEAN_EACH, STRIP_ALL_PUNCT, STRIP_ACCCENTS, TO_UPPER, TO_LOWER, STRIP_INDICATOR_2;
    };

    public abstract String getFieldTagFmt();

    public abstract FieldFormatter setFieldTagFmt(String fieldTagFmt);

    public abstract String getIndicatorFmt();

    public abstract FieldFormatter setIndicatorFmt(String indicatorFmt);

    public abstract String getSfCodeFmt(char sfCode);

    public abstract FieldFormatter setSfCodeFmt(String[] sfCodeFmt);

    public abstract String getSeparator();

    public abstract FieldFormatter setSeparator(String separator);

    public abstract eJoinVal getJoinVal();

    public abstract FieldFormatter setJoinVal(eJoinVal joinVal);
    
    public abstract FieldFormatter setSubstring(int offset, int endOffset);
 
    public abstract EnumSet<eCleanVal> getCleanVal();

    public abstract FieldFormatter setCleanVal(EnumSet<eCleanVal> cleanVal);

    public abstract FieldFormatter addCleanVal(eCleanVal cleanVal);

    public abstract Collection<String> start();

    public abstract Collection<String> makeResult();

    public abstract void addTag(VariableField df);

    public abstract void addIndicators(VariableField df);

    public abstract void addCode(String codeStr);

    public Collection<String> prepData(VariableField vf, boolean isSubfieldA, String data) throws Exception;
//  public Collection<String> prepData(VariableField vf, boolean isSubfieldA, String data) throws Exception
//    {
//        final String cleaned = cleanData(vf, isSubfieldA, data);
//        final List<String> cleanedDataAsList = (cleaned == null || cleaned.length() == 0) ? emptyList
//                : Collections.singletonList(cleaned);
//        Collection<String> result = handleMapping(cleanedDataAsList);
//        return (result);
//    }

    public abstract void addVal(String data);

    public abstract void addSeparator(int cnt);

    public abstract void addAfterSubfield(Collection<String> result);

    public abstract void addAfterField(Collection<String> result);

    public abstract String cleanData(VariableField vf, boolean isSubfieldA, String data);

    public abstract Collection<String> handleMapping(Collection<String> cleaned) throws Exception;

    public abstract String handleSubFieldFormat(String sfCode, String mappedDataVal);

//    public abstract void setFormatPatterns(String[] mapParts);



}