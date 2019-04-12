include "console.iol"
include "string_utils.iol"
include "file_worker.iol"

main
{
  split@FileWorker( "/Users/zingaro/Code/java/jolie-file-worker/test/toSplit/test.m4p" { .parts = 3 } )( response);
  valueToPrettyString@StringUtils( response )( ps );
  println@Console( ps )();
  unsplit@FileWorker( "/Users/zingaro/Code/java/jolie-file-worker/test/toSplit/test.m4p.part0" )( response);
  valueToPrettyString@StringUtils( response )( ps );
  println@Console( ps )()
}
