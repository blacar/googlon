package com.blacar.apps.googlon;

import com.blacar.apps.spike.googlon.SolutionPrinter;
import com.blacar.apps.spike.googlon.TextAnalizer;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class ValidationTests {

  private static final String file1 = "texta.txt";

  private static final List<String> vocabulary1 = Arrays.asList("sqflo", "spqinedf", "sfoqmd", "syejrqd", "shoce", "srdueqhgiy", "sionpux", "xclpedqmi", "xlmnfqry",
      "xrpmyenq", "xrdng", "ocxfsjdng", "oewgjfr", "ojxfqhernm", "cop", "coj", "cmfur", "cwj", "cpqmxj", "chwjlg", "cejfugn", "qx", "qplfjnwidg",
      "qhmoixw", "ql", "qdrulxogji", "qinhmjul", "qinexwo", "qihmu", "ncsepfl", "nmodwsqijh", "nwcrus", "nfwh", "nj", "ng", "ms", "mw", "mwd",
      "mlceo", "mjxdqfrnlg", "wxflpdn", "whc", "wjuln", "podciy", "pq", "py", "phfer", "prfmjicud", "pdoymnwxei", "fclgj", "fm", "fwdmslqn",
      "fpwcnguieh", "fdw", "fgixsr", "yco", "ycqlinro", "ylduwpsnh", "yrx", "yiq", "hysucxdqm", "hdmwpe", "hgecdfj", "en", "emjocsild", "epgdc",
      "ermjdhsx", "lwnepmcg", "lgchqdin", "jxhwe", "rsogxd", "rseoyl", "rqw", "rfimdy", "rhfl", "do", "dcnql", "dmqpchuyf", "dwuch", "dgsloqe",
      "gcxr", "ghepqyd", "ghlyopuncw", "ghu", "grewyluhfs", "us", "uo", "ucf", "ujxqh", "udr", "icmqsdj", "iw", "ifl", "iygsex", "ihncrl", "ienqm", "irmcunfgx",
      "igxweo", "ignpeyf");

  private static final String file2 = "textb.txt";

  private static final List<String> vocabulary2 = Arrays.asList("sqemywlg", "snp", "swfruc", "sdhfnoxg", "sgljco", "silruxh", "xocpjedsfm", "xchm", "xcdupho", "xy", "xyp",
      "xhrjyocde", "xrhm", "xuedl", "oxmegsdi", "oegli", "ous", "oihjwrup", "csxpy", "cnfimrgows", "cnyosu", "cwoen", "ceqrugs", "cjlxoiquef",
      "cghuwpfxly", "qncuyiel", "qgro", "nqpge", "nqhodjsm", "ndis", "mnefpj", "myngercj", "meod", "wqdgrl", "wmi", "wixmhcuynj", "poy",
      "pmrs", "fxdn", "fwqrijemcd", "fyejhi", "fhnwomgyuq", "fjnomcledi", "frqog", "yp", "yeujqcoih", "yj", "hc", "hcgeox", "hqsgcy", "hnxyfd",
      "hmypjfu", "hwuiqlne", "hyfgqj", "heixgmcy", "hlwgimn", "exmdnos", "eo", "eopq", "eofxlrd", "eqxghfry", "eqclrnguo", "efwh",
      "ehyldsnmf", "euhxmosc", "eujh", "lqeshijndg", "lf", "lhimoynsr", "lruneodc", "liyrexhmu", "jqwpdo", "jnufdshiqe", "jwroheqm",
      "jwispgefdo", "rxoew", "rcyihwxq", "rnc", "rwjxecpmfl", "rfs", "rylnsph", "dniefl", "djpsogiy", "drg", "dufqwh", "gquscxhw", "gm", "gywlc",
      "gimqxwuyr", "uxfrpsnqd", "ucrfdsoeq", "uqpwmni", "umynehjsci", "umyldn", "uwflpqc", "url", "ugnmqfypsd", "ifwpnx", "iecusqjp",
      "ijucmxw");

  private static final String file3 = "textc.txt";

  private static final List<String> vocabulary3 = Arrays.asList("sxrhen", "sngrmj", "sgd", "sunrdwm", "xqcjwsdi", "xqgjeo", "xngjhweodm", "xmry", "xfjdiy", "xfujp", "xerni",
      "xgdmopqhy", "xucq", "xigldpnw", "oncfipjg", "ogmycfqnrh", "ousryfgcqp", "oufqgmjh", "coeslhu", "chdo", "ce", "cjywmpuqns", "cjh",
      "qsixdwp", "qfderyjc", "nowmfjhgur", "nl", "nriy", "ngmwdeh", "ngrxcumijs", "meofh", "merwcxu", "mr", "miwlehxjcr", "wsuxc", "wsijx",
      "wxcjemsuf", "woyi", "wc", "wiylruxcqg", "wiergnlpfj", "prydlnc", "pde", "piuerlxhm", "fq", "fmnpo", "fw", "yodi", "ymfswnqij", "yf", "yjurqsomp",
      "yrmejs", "ydqsgjlhfn", "yijf", "hxcl", "hfnjc", "hej", "esc", "eyscgxulwn", "edyn", "lsjyndqgx", "lx", "lqyuch", "lwrjsoynp", "lyq", "leginjo", "lgxidjs",
      "jmcsorwglx", "jgnmqpesy", "ju", "jiqwscle", "rq", "rwgfe", "rfhdclgo", "rfegusyj", "rfd", "rl", "rgeoj", "rihluydngf", "dqmyeugjlo", "dwh",
      "dprhwqun", "dfcugqws", "dycjrflsn", "dunw", "gnepqwymuj", "gmuxsijo", "gelnif", "gdiusxecqj", "gucfdpx", "usqioe", "unei",
      "uhswgnpfj", "uhisd", "urflyq", "uinefd", "ionxw", "iqfwyh", "impuhyec", "ifdn");

  private static final String file4 = "textd.txt";

  private static final List<String> vocabulary4 = Arrays.asList("somhefcix", "smoxlwfnr", "sypmcelu", "sup", "xchidjpe", "xyigmqwp", "xeohlq", "xjomhfe", "osxjdqf",
      "oshnxrfpd", "oclmyr", "ow", "owupc", "opdlfnhu", "ofhledm", "ohx", "oelyg", "ojirm", "odprsxwqge", "oghqepxjlc", "oupmifrn", "csj", "csiex",
      "cn", "cnomj", "cnyxdm", "cjupdxnefm", "qsdmjlf", "qcfopnmey", "qenfdjrhcu", "qlw", "qd", "qdlhjmeno", "nsjopuw", "nxgupwhl",
      "nfcmxjwgl", "neiwlogrsy", "njdy", "nrxu", "mxdplruge", "mrsylhxwqf", "mdgr", "muf", "wqphu", "pxryc", "pnciyrl", "puisec", "pirfd", "fxgs",
      "fcqlpoiu", "fn", "fhsogp", "feru", "fd", "fdmrsl", "fu", "fuqrlid", "ysw", "yqwxn", "yricqxhfeo", "yghuecdj", "yumrfio", "yupjenqmf", "hmsp", "hmie",
      "hpjfnlqy", "hgwcms", "hiwn", "eopi", "eunyd", "ls", "lxng", "lcyehfi", "lnsdioe", "lfro", "jsuh", "jcoer", "jcfye", "jndfyqm", "jywenuqr", "jui", "rcpdlo",
      "ryshjxdc", "dowueprmc", "dmgxjholu", "dyuhwxc", "dr", "gwucos", "gh", "us", "unowmxiecd", "uewdymsl", "ulrosdm", "udjnylie",
      "icwgux", "iw", "ihpslwgoqm", "ig");

  private static final String file5 = "texte.txt";

  private static final List<String> vocabulary5 = Arrays.asList("sxwc", "syjqfr", "srhm", "sinprhlwdm", "xwqmucp", "xwule", "ocmhp", "oylfmierg", "ojgelhisc", "orl", "odi", "oux",
      "cndlxuqhfg", "cpgyx", "ch", "cjxdl", "cgr", "ciex", "qpngufxjli", "qhiwfyudsp", "qehcmrjpwu", "qljs", "qrj", "qugre", "nsdohjim", "ncjysiwdh",
      "nqc", "nqeduhc", "ndepfswml", "ms", "mqgwclf", "mwrpcg", "mfginrqulc", "mexfjsi", "mjrliogucs", "mgnoqdjh", "muoplcrfi",
      "wxmyhipou", "wpxgyh", "wydjx", "wisly", "pxiomfqwrd", "pqf", "pmldxecqf", "pysfieucx", "phlyf", "phdgqir", "peqfw", "fsxcerumow",
      "fqexsi", "fwerpnxogs", "yqmgihus", "ywcr", "ypwocmxni", "yedhpws", "ylnxequr", "yjgq", "yrshie", "yinjs", "hsfywx", "hwsqc", "hwmjp",
      "hpngdocxw", "hygu", "hjwsqel", "hdroml", "hgcmqix", "exsij", "eorq", "ec", "eq", "emnd", "epqdonschm", "ey", "edmpwfnsuh", "lx", "ljsf", "jnqul",
      "jrcdiye", "jimlxfsygc", "rxsfecil", "rnpjw", "rjoh", "rijpsfgm", "dje", "dimxwofheq", "goi", "gn", "gnl", "uspxjgdlei", "umwrc", "umrocw", "up",
      "ufidryq", "isxl", "icy", "ipoufr", "iyuq", "irplxyofsm", "iupdjfnhm");

  @Test
  public void testCase1() {
    final TextAnalizer analizer = new TextAnalizer(getFileContent(file1));
    new SolutionPrinter(analizer).print();
    System.out.println("Vocabulary list: " + vocabulary1);
    Assert.assertTrue(analizer.getPrepositions() == 3);
    Assert.assertTrue(analizer.getVerbs() == 36);
    Assert.assertTrue(analizer.getSubjuntiverbs() == 25);
    Assert.assertTrue(analizer.getOrderedwords().equals(vocabulary1));
    Assert.assertTrue(analizer.getPrettyNumbers() == 22);
  }

  @Test
  public void testCase2() {
    final TextAnalizer analizer = new TextAnalizer(getFileContent(file2));
    new SolutionPrinter(analizer).print();
    Assert.assertTrue(analizer.getPrepositions() == 3);
    Assert.assertTrue(analizer.getVerbs() == 46);
    Assert.assertTrue(analizer.getSubjuntiverbs() == 26);
    Assert.assertTrue(analizer.getOrderedwords().equals(vocabulary2));
    Assert.assertTrue(analizer.getPrettyNumbers() == 21);
  }

  @Test
  public void testCase3() {
    final TextAnalizer analizer = new TextAnalizer(getFileContent(file3));
    new SolutionPrinter(analizer).print();
    Assert.assertTrue(analizer.getPrepositions() == 2);
    Assert.assertTrue(analizer.getVerbs() == 37);
    Assert.assertTrue(analizer.getSubjuntiverbs() == 22);
    Assert.assertTrue(analizer.getOrderedwords().equals(vocabulary3));
    Assert.assertTrue(analizer.getPrettyNumbers() == 27);
  }

  @Test
  public void testCase4() {
    final TextAnalizer analizer = new TextAnalizer(getFileContent(file4));
    new SolutionPrinter(analizer).print();
    Assert.assertTrue(analizer.getPrepositions() == 3);
    Assert.assertTrue(analizer.getVerbs() == 31);
    Assert.assertTrue(analizer.getSubjuntiverbs() == 19);
    Assert.assertTrue(analizer.getOrderedwords().equals(vocabulary4));
    Assert.assertTrue(analizer.getPrettyNumbers() == 27);
  }

  @Test
  public void testCase5() {
    final TextAnalizer analizer = new TextAnalizer(getFileContent(file5));
    new SolutionPrinter(analizer).print();
    Assert.assertTrue(analizer.getPrepositions() == 1);
    Assert.assertTrue(analizer.getVerbs() == 32);
    Assert.assertTrue(analizer.getSubjuntiverbs() == 19);
    Assert.assertTrue(analizer.getOrderedwords().equals(vocabulary5));
    Assert.assertTrue(analizer.getPrettyNumbers() == 26);
  }

  private String getFileContent(final String filename) {
    final StringBuilder contentBuilder = new StringBuilder();
    try (Stream<String> stream = Files.lines(
        Paths.get(getClass().getClassLoader().getResource(filename).getPath()),
        StandardCharsets.UTF_8)
    ) {
      stream.forEach(s -> contentBuilder.append(s).append(" "));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return contentBuilder.toString();
  }
}
