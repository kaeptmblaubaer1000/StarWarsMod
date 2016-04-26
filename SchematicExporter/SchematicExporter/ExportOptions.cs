using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SchematicExporter
{
    struct ExportOptions
    {
        public String fileName;
        public String package;
        public String className;

        public ExportOptions(String fileName, String package, String className)
        {
            this.fileName = fileName;
            this.package = package;
            this.className = className;
        }
    }
}
