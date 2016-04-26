using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SchematicExporter
{
    class Block
    {
        String name;
        String namespacePrefix;

        public Block(String name, String namespacePrefix)
        {
            this.name = name;
            this.namespacePrefix = namespacePrefix;
        }

        public String getName()
        {
            return this.name;
        }

        public String getNamespacePrefix()
        {
            return this.namespacePrefix;
        }

        public String createJavaVariable()
        {
            return String.Format("{0}.{1}", this.namespacePrefix, this.name);
        }
    }
}
