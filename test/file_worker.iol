type SplitRequestType: string { // the path for the file to be split
  .parts: int // number of parts the file should be split
}

type SplitResponseType: void {
  .splits[1,*]: string // the paths of the split files
}

type UnsplitRequestType: string // the path for the first split file, e.g. name.zip.part0

type UnsplitResponseType: string // the path for the joined file

interface FileWorkerInterface {
RequestResponse:
split   ( SplitRequestType )( SplitResponseType ),
unsplit ( UnsplitRequestType )( UnsplitResponseType )
}

outputPort FileWorker {
  Interfaces: FileWorkerInterface
}

embedded {
  Java: "org.jolie.worker.WorkerService" in FileWorker
}
