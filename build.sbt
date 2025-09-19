name := "dfdl-fakeTDL"

organization := "com.owlcyberdefense"

version := "1.0.4" // updated for Daffodil 4.0.0

// for details about DaffodilPlugin settings, see https://github.com/apache/daffodil-sbt
enablePlugins(DaffodilPlugin)

daffodilFlatLayout := true

daffodilVersion := daffodilPackageBinVersions.value.head

// note that due to scala 2.13, you can choose either 3.11.0 OR versions up to 3.10.0 (which use scala 2.12)
daffodilPackageBinVersions := Seq("4.0.0") // Seq("3.10.0", "3.9.0", "3.8.0", "3.7.0", "3.5.0", "3.4.0")

// scalaVersion := "2.13.16" // Required for daffodil 3.11.0 as of 2025-07-07

daffodilPackageBinInfos := Seq(
  // schema for a single message
  DaffodilBinInfo("/fakeTDL.dfdl.xsd", root = Some("fakeTDL"), name = Some("fakeTDL")),
  // schema for a file of messages
  DaffodilBinInfo("/fakeTDL.dfdl.xsd", root = Some("fakeTDLFile"), name = Some("fakeTDLFile"))
)

// not necessary for this small schema, but for larger schemas
// where schema compilation takes a while this is important
daffodilTdmlUsesPackageBin := true
