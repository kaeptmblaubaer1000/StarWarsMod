namespace SchematicExporter
{
    internal struct ExportOptions
    {
        public string FileName;
        public string Package;
        public string ClassName;

        public ExportOptions(string fileName, string package, string className)
        {
            FileName = fileName;
            Package = package;
            ClassName = className;
        }
    }
}
