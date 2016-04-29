namespace SchematicExporter
{
    internal class Block
    {
        private readonly string _name;
        private readonly string _namespacePrefix;

        public Block(string name, string namespacePrefix)
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

        public Item ToItem()
        {
            return new Item(_name, _namespacePrefix);
        }
    }
}
