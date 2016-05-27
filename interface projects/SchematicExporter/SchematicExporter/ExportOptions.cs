namespace SchematicExporter
{
    internal struct ExportOptions
    {
        public string FileName;
        public string Package;
        public string ClassName;
        public string Path;

        public ExportOptions(string fileName, string package, string className, string path)
        {
            FileName = fileName;
            Package = package;
            ClassName = className;
            Path = path;
        }
    }
}
