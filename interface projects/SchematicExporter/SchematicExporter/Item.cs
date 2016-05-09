namespace SchematicExporter
{
    internal class Item
    {
        private readonly string _name;
        private readonly string _namespacePrefix;

        public Item(string name, string namespacePrefix)
        {
            _name = name;
            _namespacePrefix = namespacePrefix;
        }

        public string GetName()
        {
            return _name;
        }

        public string GetNamespacePrefix()
        {
            return _namespacePrefix;
        }

        public string CreateJavaVariable()
        {
            return string.Format("{0}.{1}", _namespacePrefix, _name);
        }

        public Block ToBlock()
        {
            return new Block(_name, _namespacePrefix);
        }
    }
}
