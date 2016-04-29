namespace SchematicExporter
{
    internal class Entity
    {
        private readonly string _jClass;
        private readonly string _package;

        public Entity(string jClass, string package)
        {
            _jClass = jClass;
            _package = package;
        }

        public string GetName()
        {
            return _jClass;
        }

        public string GetPackage()
        {
            return _package;
        }

        public string GetQualifiedName()
        {
            return _package + "." + _jClass;
        }
    }
}
